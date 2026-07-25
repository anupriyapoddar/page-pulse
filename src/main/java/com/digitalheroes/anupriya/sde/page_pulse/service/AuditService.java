package com.digitalheroes.anupriya.sde.page_pulse.service;

import com.digitalheroes.anupriya.sde.page_pulse.model.AuditResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public AuditResponse auditUrl(String targetUrl) {
        AuditResponse response = new AuditResponse();
        response.setUrl(targetUrl);
        long startTime = System.currentTimeMillis();

        try {
            Connection.Response res = Jsoup.connect(targetUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) PagePulseBot/1.0")
                    .timeout(5000)
                    .followRedirects(true)
                    .execute();

            response.setResponseTimeMs(System.currentTimeMillis() - startTime);
            response.setHttpStatus(res.statusCode());

            String contentType = res.contentType();
            if (contentType == null || !contentType.toLowerCase().contains("text/html")) {
                throw new RuntimeException("Non-HTML response type");
            }

            Document doc = res.parse();

            // Page Title
            response.setPageTitle(doc.title());

            // Meta Description
            Element metaDesc = doc.selectFirst("meta[name=description]");
            response.setMetaDescription(metaDesc != null ? metaDesc.attr("content") : null);

            // H1 Count
            response.setH1Count(doc.select("h1").size());

            // Missing Alt Images Count
            Elements images = doc.select("img");
            int missingAlt = 0;
            for (Element img : images) {
                String alt = img.attr("alt");
                if (alt == null || alt.trim().isEmpty()) {
                    missingAlt++;
                }
            }
            response.setMissingAltImagesCount(missingAlt);

            // Word Count
            String bodyText = doc.body() != null ? doc.body().text() : "";
            response.setApproximateWordCount(bodyText.isEmpty() ? 0 : bodyText.split("\\s+").length);

        } catch (Exception e) {
            response.setHttpStatus(500);
            response.setResponseTimeMs(System.currentTimeMillis() - startTime);
        }

        return response;
    }
}

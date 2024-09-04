package com.tdd.eCommerceApp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

    public static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    public static String objectToJsonString(Object object) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String x = ow.writeValueAsString(object);
            x = x.replaceAll("\n", "");
            x = x.replaceAll("\r", "");
            return x;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }


}

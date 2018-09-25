package com.example.markettrade.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class MarketTradeStringUtils {
	
	/**
     * Default ToStringStyle set to SHORT_PREFIX_STYLE
     * 
     * @param object
     * @return String representation of object.
     */
    public static String toString(Object object) {
        return toString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
    /**
     * @see org.apache.commons.lang3.builder.ReflectionToStringBuilder#reflectionToString(Object,
     *      ToStringStyle)
     * 
     * @param object For which string generation required.
     * @param style
     * @return if provided object is null then null else string representation of object.
     */
    public static String toString(Object object, ToStringStyle style) {
        // This is the workaround for the known issue in ReflectionToStringBuilder that It throws
        // exception while printing null values.
        return object == null ? null : ReflectionToStringBuilder.reflectionToString(object, style);
    }
	
	/**
     * This method provides flexibility to skip any fields to getting involved in toString
     * generation
     * 
     * @param object For which string generation required.
     * @param fieldsToIgnore list of fields which needs to be ignored from string generation.
     * @return String representation of object.
     */
    public static String toString(Object object, final String... fieldsToIgnore) {
        if (object == null) {
            return null;
        }

        return new ReflectionToStringBuilder(object, ToStringStyle.SHORT_PREFIX_STYLE)
                .setExcludeFieldNames(fieldsToIgnore).build();
    }


}

package com.example.springbatchdemo.separator;

import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;

public class SkipBlankLinePolicy extends SimpleRecordSeparatorPolicy {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEndOfRecord(String line) {
        if(line.contains(";"))
            line =  line.replaceAll(";", ",");
        return super.isEndOfRecord(line);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String postProcess(String record) {
        if(record.contains(";"))
            record =  record.replaceAll(";", ",");
        return super.postProcess(record);
    }
}


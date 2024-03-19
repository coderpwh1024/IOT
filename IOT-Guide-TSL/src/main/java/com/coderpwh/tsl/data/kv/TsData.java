package com.coderpwh.tsl.data.kv;

/**
 * @author coderpwh
 */
public class TsData implements Comparable<TsData>{


    private  final  long ts;

    private  final Object value;
    public TsData(long ts, Object value) {
        this.ts = ts;
        this.value = value;
    }

    public long getTs() {
        return ts;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public int compareTo(TsData o) {
        return  Long.compare(ts,o.ts);
    }


}

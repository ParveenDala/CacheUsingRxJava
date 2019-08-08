package model;

/*************
 * Parveen D
 * Cache Using RxJava
 */
public class Data {
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public Data clone() {
        return new Data();
    }
}

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
    protected Data clone() throws CloneNotSupportedException {
        return new Data();
    }
}

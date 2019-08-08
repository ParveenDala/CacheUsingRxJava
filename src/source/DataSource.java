package source;

import io.reactivex.Observable;
import model.Data;

/*************
 * Parveen D
 * Cache Using RxJava
 */
public class DataSource {
    private MemorySource memorySource;
    private DiskSource diskSource;
    private NetworkSource networkSource;

    public DataSource(MemorySource memorySource, DiskSource diskSource, NetworkSource networkSource) {
        this.memorySource = memorySource;
        this.diskSource = diskSource;
        this.networkSource = networkSource;
    }

    public Observable<Data> getDataFromMemory() {
        return memorySource.getData();
    }

    public Observable<Data> getDataFromDisk() {
        return diskSource.getData();
    }

    public Observable<Data> getDataFromNetwork() {
        return networkSource.getData();
    }

}

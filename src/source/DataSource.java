package source;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
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
        return diskSource.getData().doAfterNext(new Consumer<Data>() {
            @Override
            public void accept(Data data) throws Exception {
                memorySource.saveToMemory(data);
            }
        });
    }

    public Observable<Data> getDataFromNetwork() {
        return networkSource.getData().doOnNext(new Consumer<Data>() {
            @Override
            public void accept(Data data) throws Exception {
                diskSource.saveToDisk(data);
                memorySource.saveToMemory(data);
            }
        });
    }

}

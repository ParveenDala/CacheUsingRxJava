package source;

import io.reactivex.Observable;
import model.Data;

/*************
 * Parveen D
 * Cache Using RxJava
 */
public class MemorySource {

    private Data data;

    public Observable<Data> getData() {
        return Observable.create(emitter -> {
            if (data != null)
                emitter.onNext(data);
            emitter.onComplete();
        });
    }

    public void saveToMemory(Data data) {
        this.data = data.clone();
        this.data.setSource("Memory");
    }

}

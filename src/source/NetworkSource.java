package source;

import io.reactivex.Observable;
import model.Data;

/*************
 * Parveen D
 * Cache Using RxJava
 */
public class NetworkSource {

    public Observable<Data> getData() {
        return Observable.create(emitter -> {
            Data data = new Data();
            data.setSource("Network");
            emitter.onNext(data);
            emitter.onComplete();
        });
    }

}

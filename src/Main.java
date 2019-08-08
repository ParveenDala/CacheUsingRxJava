import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import model.Data;
import source.DataSource;
import source.DiskSource;
import source.MemorySource;
import source.NetworkSource;

/*************
 * Parveen D
 * Cache Using RxJava
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        DataSource dataSource = new DataSource(new MemorySource(), new DiskSource(), new NetworkSource());
        main.getData(dataSource);
        Thread.sleep(500);
        main.getData(dataSource);
        Thread.sleep(500);
        main.getData(dataSource);
    }

    private void getData(DataSource dataSource) {
        Observable.concat(
                dataSource.getDataFromMemory(),
                dataSource.getDataFromDisk(),
                dataSource.getDataFromNetwork()
        )
                .firstElement()
                .toObservable()
                .subscribe(dataObserver);

    }

    private Observer<Data> dataObserver = new Observer<Data>() {
        @Override
        public void onSubscribe(Disposable disposable) {
            System.out.println("\nOnSubscribe");
        }

        @Override
        public void onNext(Data data) {
            System.out.println("Data From " + data.getSource());
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("OnError " + throwable.getLocalizedMessage());
        }

        @Override
        public void onComplete() {
        }
    };

}

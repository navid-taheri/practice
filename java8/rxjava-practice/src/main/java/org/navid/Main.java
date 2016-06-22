package org.navid;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by navid on 2016-06-21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //useActionInterface();
        //useLambda();
        useCustomObserver();
    }


    public static void useCustomObserver() throws IOException {
        File f = new File("/home/navid/t/g");
        InputStream is = new FileInputStream(f);

        /*
        int content;
        while ((content = is.read()) != -1) {
            // convert to char and display it
            System.out.print((char) content);
        }
        */


        FileInputStream in = new FileInputStream("src/main/resources/input");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));



        ConnectableObservable<String> co = fromReader(br);


                co.map(s -> {
                    return s + ".";
                })
                .subscribe(s -> System.out.println(s));

        co.connect();



    }


    public static ConnectableObservable<String> fromReader(final BufferedReader reader) {
        return Observable.create((Subscriber<? super String> subscriber) -> {
            try {
                String line;

                if (subscriber.isUnsubscribed()) {
                    return;
                }

                while (!subscriber.isUnsubscribed() && (line = reader.readLine()) != null) {
                    if (line.equals("exit")) {
                        break;
                    }

                    subscriber.onNext(line);
                }
            } catch (IOException e) {
                subscriber.onError(e);
            }

            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }).publish();
    }


    public static void useLambda(){
        List<String> names = new ArrayList<String>();
        names.add("AAA");
        names.add("BBB");
        names.add("CCC");
        names.add("DDD");

        Observable.from(names)
                .map(s -> {
                    return s + ".";
                })
                .subscribe(s -> System.out.println(s));
    }

    public static void useActionInterface(){
        List<String> names = new ArrayList<String>();
        names.add("AAA");
        names.add("BBB");
        names.add("CCC");
        names.add("DDD");

        Observable<String> observable =  Observable.from(names);

        observable.subscribe(
                new Action1<String>() {
                    public void call(String s) {
                        System.out.println("Hello " + s + "!");
                    }
                });
    }
}

package Problem1;

public class Main {
    //Question - 1 ---> Meaning of deadlock

    /*Deadlock is a situation in multithreading where two or more threads try to access
    * the same resource at the same time. But none of them can get access to it and they go
    * into waiting mode infinitely as they're waiting for the other to release the lock.
    *
    * For e.g.
    * Object A wants to access  a method of Object B and Object B wants to access a method
    *  from Object-A but Thread-0 has acquired the lock of Object-A and
    * Thread-1 has acquired the lock of Object B. This is a deadlock and both of them will keep
    * waiting for the other to release the lock
    *
    *
    * In a multithreaded application this situation may arise when -
    * Two objects are trying to get data from each other, and BOTH OF THEM ARE SYNCHRONISED ,
    *
    *
    * ---- Prevention ----*/
    /*-> This can be prevented by simply re-ordering statements with shared resources.
    * -> We can remove synchronised keyword from the controversial resource
    * -> We can use Join()
    **/
}

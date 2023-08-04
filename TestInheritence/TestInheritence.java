class Cache {}
class DiskCache extends Cache {}
class MemoryCache extends Cache {}
class OptimizedDiskCache extends DiskCache {}

public class TestInheritence {
    public static void main(String[] args) {
        // upcasting
        Cache cache = new Cache();
        //MemoryCache memoryCache = (MemoryCache)cache; // upcasting fails

        // down and then upcasting works
        OptimizedDiskCache optDiskCache = new OptimizedDiskCache();
        Cache cache2 = (Cache)optDiskCache;
        DiskCache cache3 = (DiskCache)cache2;
        OptimizedDiskCache cache4 = (OptimizedDiskCache)cache2;
    }
}


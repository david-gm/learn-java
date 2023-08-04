class Cache {}
class DiskCache extends Cache {}
class MemoryCache extends Cache {}
class OptimizedDiskCache extends DiskCache {}

public class TestInheritence {
    public static void main(String[] args) {
        Cache cache = new Cache();
        MemoryCache memoryCache = (MemoryCache)cache;
    }
}


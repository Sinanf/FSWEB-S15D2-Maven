package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks,
                    Set<Task> bobsTasks,
                    Set<Task> carolsTasks,
                    Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }


    public Set<Task> getTasks(String who) {
        if (who == null) return Set.of();
        switch (who.toLowerCase()) {
            case "ann":   return annsTasks;
            case "bob":   return bobsTasks;
            case "carol": return carolsTasks;
            case "all":   return getUnion(getUnion(annsTasks, bobsTasks), carolsTasks);
            default:      return Set.of();
        }
    }

    // --- Set yardımcıları (static & generic) ---
    public static <T> Set<T> getUnion(Set<T> a, Set<T> b) {
        Set<T> r = new HashSet<>(a);
        r.addAll(b);
        return r;
    }

    public static <T> Set<T> getIntersection(Set<T> a, Set<T> b) {
        Set<T> r = new HashSet<>(a);
        r.retainAll(b);
        return r;
    }

    public static <T> Set<T> getDifferences(Set<T> a, Set<T> b) {
        Set<T> r = new HashSet<>(a);
        r.removeAll(b);
        return r;
    }
}

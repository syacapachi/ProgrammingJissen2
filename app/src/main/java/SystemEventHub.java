import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class SystemEventHub {
    private static final Map<Class<?>, List<Consumer<?>>> events = new HashMap<>();

    public static <T> void Publish(T event){
        for (Map.Entry<Class<?>, List<Consumer<?>>> entry : events.entrySet()) {
            if (entry.getKey().isAssignableFrom(event.getClass())) {
                for (Consumer<?> consumer : entry.getValue()) {
                    @SuppressWarnings("unchecked")
                    Consumer<T> action = (Consumer<T>) consumer;
                    action.accept(event);
                }
            }
        }
    }
    public static <T> void Subscribe(Class<T> type,Consumer<T> action){
        events.computeIfAbsent(type,(v)-> new ArrayList<>()).add(action);
    }
    public static <T> void Unsubscribe(Class<T> type,Consumer<T> action){
        List<Consumer<?>> list = events.get(type);
        if (list != null) {
            list.remove(action);
        }
    }
}

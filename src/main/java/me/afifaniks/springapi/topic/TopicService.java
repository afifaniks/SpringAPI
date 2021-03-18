package me.afifaniks.springapi.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic(
                    "spring",
                    "Spring Course",
                    "Course about Spring"
            ),
            new Topic(
                    "java",
                    "Java Course",
                    "Course about Java"
            ))
    );

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        try {
            return topics.stream().filter(
                    topic ->
                            topic.getId().equals(id)
            ).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic toBeChanged = topics.get(i);

            if (toBeChanged.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void delTopic(String id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic toBeChanged = topics.get(i);

            if (toBeChanged.getId().equals(id)) {
                topics.remove(i);
                return;
            }
        }
    }
}

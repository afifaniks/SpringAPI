package me.afifaniks.springapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping
    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Object getTopic(@PathVariable String id) {
        Optional<Topic> topic = topicService.getTopic(id);

        if (!topic.isPresent()) {
            return new ArrayList<Topic>();
        }
        return topic;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.delTopic(id);
    }
}

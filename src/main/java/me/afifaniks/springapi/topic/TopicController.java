package me.afifaniks.springapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
        Topic topic = topicService.getTopic(id);

        if (topic == null) {
            return "No such element";
        }
        return topic;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }
}

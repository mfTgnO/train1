package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @package: com.example.demo.domain
 * @author:
 * @email:
 * @createDate: 2019-05-23 17:49
 * @description:
 */
@Entity
@Table(name = "story")
public class Story implements Serializable {

    private static final long serialVersionUID = 3547160085414398010L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storyId;

    @Column(name = "story_name")
    private String storyName;

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }
}

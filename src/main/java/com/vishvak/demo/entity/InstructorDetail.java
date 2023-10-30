package com.vishvak.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructor_detail")
@Data
@NoArgsConstructor
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    // We are using mappedBy attribute in the OneToOne annotation here because we are establishing a bidirectional mapping
    // In the mappedBy attribute the value should be not that of the column name but of the field/variable name of the foreign key
    // in the other Entity class.

    // Since we have also enabled Cascading that means if an object of "instructor_detail" has been persisted or removed then the same will
    // be performed for the associated instructor table object.
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail(String youtubeChannel, String hobby){
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}

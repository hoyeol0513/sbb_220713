package com.mysite.sbb.Answer;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mysite.sbb.Question.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
//JsonIdentityInfo를 넣음으로써 무한루프에 빠지는 것을 방지.
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;

    private Boolean replyLike;

}
//sql에서 true/false를 제대로 인식하지 못해서 converter로 y,n로 바꿈
@Converter
class BooleanToYNConverter implements AttributeConverter<Boolean, String>{
    @Override
    public String convertToDatabaseColumn(Boolean attribute){
        return (attribute != null && attribute) ? "Y" : "N";
    }
    @Override
    public Boolean convertToEntityAttribute(String dbData){
        return "Y".equals(dbData);
    }
}

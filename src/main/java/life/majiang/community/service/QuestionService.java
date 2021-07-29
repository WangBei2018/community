package life.majiang.community.service;

import life.majiang.community.DTO.PaginationDTO;
import life.majiang.community.DTO.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/7/8 17:36
 * @Description:
 */
@Service
// 中间层，用来组装Question和User类,因为在搜索问题的同时需要显示用户的头像，则需要访问用户类。
public class QuestionService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {

        Integer offset = (page - 1) * size;

        // 在这里返回的Question对象中的各个变量的命名使用的是下划线（例如avatar_url------avatarURL），而Question对象中的变量明明是驼峰表示，
        // 所以需要在配置文件中配置mybatis.configuration.map-underscore-to-camel-case=true
        List<Question> questions = questionMapper.list(offset, size);

        PaginationDTO paginationDTO = new PaginationDTO();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator()); // 通过id找到用户对象
            QuestionDTO questionDTO = new QuestionDTO();            //包含Question类变量以及用户类对象
            BeanUtils.copyProperties(question, questionDTO);        // 将question对象中相应的数据拷贝到questionDTO对象中
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        return paginationDTO;
    }
}

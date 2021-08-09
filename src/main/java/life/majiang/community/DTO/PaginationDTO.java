package life.majiang.community.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/7/14 16:57
 * @Description:
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;

    private Integer page;       // 当前页
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();// 当前显示的页码列表

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if (totalCount % size == 0) {           // 计算总共的页码数
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;

        pages.add(page);
        for (int i = 1; i <= 3; i++) {          // 前后展示三个页码
            if (page - i > 0) {
                pages.add(0, page - i); // 第一个参数是0，表示头部插入
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        // 是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}

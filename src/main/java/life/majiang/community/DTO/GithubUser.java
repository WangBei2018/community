package life.majiang.community.DTO;

/**
 * @Author WangBei
 * @Date 2021/6/7 16:59
 */
public class GithubUser {
    private String name;
    private Long Id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

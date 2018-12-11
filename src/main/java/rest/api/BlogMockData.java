package rest.api;

import java.util.ArrayList;
import java.util.List;

public class BlogMockData {

    private List<Blog> blogs;

    private static BlogMockData instance = null;

    public  static BlogMockData getInstance(){

        if(instance == null){
            instance = new BlogMockData();
        }
        return instance;
    }

    public  BlogMockData(){

        blogs   = new ArrayList<Blog>();

        blogs.add(new Blog(1, "Blog Title One", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"));
        blogs.add(new Blog(2, "Blog Title Two", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"));
        blogs.add(new Blog(3, "Blog Title Three", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"));

    }

    public  List<Blog> fetchBlog(){
        return blogs;
    }

    public Blog getById(int id){
        for (Blog b : blogs){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }


    public List<Blog> searchByText(String searchParam){

        List<Blog>  listFoundBlog = new ArrayList<>();

        for(Blog b : blogs){
            if(b.getTitle().toLowerCase().contains(searchParam.toLowerCase()) || b.getContent().toLowerCase().contains(searchParam.toLowerCase())){
                listFoundBlog.add(b);
            }
        }

        return listFoundBlog;


    }


    public Blog createBlog(int id, String title, String content){

        Blog newBlog = new Blog(id, title, content);

        blogs.add(newBlog);

        return newBlog;

    }

    public Blog updateBlog(int id, String title, String content){
        Blog editBlog   = new Blog(id, title, content);

        for (Blog b : blogs){

            if(b.getId() == id){
                int blogIndex = blogs.indexOf(b);
                blogs.set(blogIndex, editBlog);

                return editBlog;
            }
        }

        return null;
    }


    public Boolean deleteBlog(int id){

        int blogIndex = -1;

        for (Blog b : blogs){
            if(b.getId() == id){
                blogIndex = blogs.indexOf(b);
            }
        }
        if(blogIndex > -1){
              blogs.remove(blogIndex);
        }

        return true;
    }

}

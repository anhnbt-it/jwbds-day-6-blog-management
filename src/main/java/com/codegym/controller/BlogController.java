package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    ModelAndView showBlogs() {
        Iterable<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("blogs");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("title", "Create Blog");
        return modelAndView;
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> create(HttpServletRequest request) {
        String title = request.getParameter("title");
        String image = request.getParameter("image");
        String content = request.getParameter("content");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

        Blog blog = new Blog(title, image, content, status);
        Blog saveBlog = (Blog) blogService.save(blog);

        Map<String, String> map = new HashMap<>();
        if (saveBlog.getId() != null) {
            map.put("status", HttpStatus.OK.toString());
            map.put("message", "New record created successfully.");
        } else {
            map.put("status", HttpStatus.NOT_FOUND.toString());
            map.put("message", "Something went wrong.");
        }
        return map;
    }
}

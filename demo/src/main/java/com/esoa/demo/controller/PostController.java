
package com.esoa.demo.controller;

import com.esoa.demo.entity.Post;
import com.esoa.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ModelAndView getPost(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("post-table");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) mav.addObject("success", inputFlashMap.get("success"));

        mav.addObject("post", postService.getAll());
        return mav;
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/form")
    public ModelAndView getPostForm(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("post-form");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            mav.addObject("post", inputFlashMap.get("post"));
            mav.addObject("exception", inputFlashMap.get("exception"));
        } else {
            mav.addObject("post", new Post());
        }

        mav.addObject("action", "create");
        return mav;
    }
    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/form/{id}")
    public ModelAndView getPostForm(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("post-form");
        mav.addObject("post", postService.getById(id));
        mav.addObject("action", "update");
        return mav;
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public RedirectView create(Post dto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/posts");

        try {
            postService.create(dto);
            attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        } catch (IllegalArgumentException e) {
            attributes.addFlashAttribute("post", dto);
            attributes.addFlashAttribute("exception", e.getMessage());
            redirect.setUrl("/posts/form");
        }

        return redirect;
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public RedirectView update(Post dto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/posts");
        postService.update(dto);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/enable/{id}")
    public RedirectView enable(@PathVariable Integer id) {
        postService.enableById(id);
        return new RedirectView("/posts");
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Integer id) {
        RedirectView redirect = new RedirectView("/posts");
        postService.deleteById(id);
        return redirect;
    }
    //agregar la parte de eliminados
    //agregar el listado
}
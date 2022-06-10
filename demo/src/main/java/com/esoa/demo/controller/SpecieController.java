
package com.esoa.demo.controller;

import com.esoa.demo.service.SpecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/species")
public class SpecieController {

    private final SpecieService specieService;
    //falta rol
    @GetMapping
    public ModelAndView getSpecies(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("species-table"); //ver nombre de hmtl
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) mav.addObject("success", inputFlashMap.get("success"));

        mav.addObject("species", specieService.getAll());
        return mav;
    }




}

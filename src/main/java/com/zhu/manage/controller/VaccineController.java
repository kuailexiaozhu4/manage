package com.zhu.manage.controller;

import com.zhu.manage.domain.Vaccine;
import com.zhu.manage.service.VaccineService;
import com.zhu.manage.utils.Page;
import com.zhu.manage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    @Autowired
    private VaccineService vaccineService;

    //查询疫苗信息
    @GetMapping("/{current}/{size}")
    public Result getVaccines(@PathVariable Long current, @PathVariable Long size, Vaccine vaccine) {
        Page page = vaccineService.getPage(current, size, vaccine);
        if (current > page.getPageNumber()) {
            page = vaccineService.getPage(1L, size, vaccine);
        }
        return Result.success("获取数据成功", page);
    }

    @PostMapping
    public Result saveVaccine(@RequestBody Vaccine vaccine) {
        Boolean flag = vaccineService.saveVaccine(vaccine);
        return flag == true ? Result.success("添加成功", null) : Result.fail("添加失败");
    }

    @PutMapping
    public Result updateVaccine(@RequestBody Vaccine vaccine) {
        Boolean flag = vaccineService.updateVaccine(vaccine);
        if (flag) return Result.success("修改成功", true);
        else return Result.fail("修改失败");
    }

    @DeleteMapping()
    public Result deleteVaccine(@RequestBody List<Integer> ids) {
        Boolean flag = vaccineService.deleteVaccineByIds(ids);
        if (flag) return Result.success("删除成功", null);
        else return Result.fail("删除失败");
    }
}

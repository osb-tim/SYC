package controller;


import Dao.Util.WiKiDao;
import database.WiKiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/wiki",produces = "application/json;charset=UTF-8")
public class WiKi {


    @Autowired
    private WiKiDao wiKiDao;

    @RequestMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void upload(@RequestBody WiKiEntity wiKiEntity) {
        wiKiDao.upload(wiKiEntity);
    }

    @RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void delete(@RequestBody WiKiEntity wiKiEntity) {
        wiKiDao.delete(wiKiEntity);
    }

    @RequestMapping(value = "/update", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void update(@RequestBody WiKiEntity wiKiEntity) {
        wiKiDao.update(wiKiEntity);
    }

    @RequestMapping(value = "/getWikiById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getWikiById(@RequestBody WiKiEntity wiKiEntity) {
        Object result;
        if (wiKiEntity.isIfAuthor() || wiKiEntity.isIfPublic()) {
            result = wiKiDao.getWiki(wiKiEntity);
        } else {
            result="对方设置为私密";
        }
        return result;

    }

    @RequestMapping(value = "/getWikisByAuthorId", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<WiKiEntity> getWikisByAuthorId(@RequestBody WiKiEntity wiKiEntity) {
        List<WiKiEntity> result = wiKiDao.getWikisByAuthorId(wiKiEntity);
        return result;
    }

    @RequestMapping(value = "/getAllPublicWikis",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<WiKiEntity> getAllPublicWikis(){
        List<WiKiEntity> result = wiKiDao.getAllPublicWikis();
        return result;
    }


}

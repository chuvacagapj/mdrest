package controllers;

import com.google.gson.Gson;
import models.MarkdownModel;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by jesus on 28/11/16.
 */
public class JsonController extends Controller {

    public static void createMarkdown(){
        String json = params.get("json");
        Gson gson = new Gson();

        MarkdownModel model = gson.fromJson(json, MarkdownModel.class);
        if (model.id == null){
            model.save();
        }else{
            MarkdownModel actual = MarkdownModel.findById(model.id);
            actual.title = model.title;
            actual.body = model.body;
            actual.merge();
            model = actual;
        }
        renderJSON(model);
    }

    public static void listMarkdown(){
        List<MarkdownModel> list = MarkdownModel.findAll();
        renderJSON(list);
    }

    public static void showMarkdown(Long id){
        MarkdownModel mk = MarkdownModel.findById(id);
        renderJSON(mk);
    }

    public static void deleteMarkdown(Long id){
        MarkdownModel model = MarkdownModel.findById(id);
        model.delete();
        ok();

    }
}

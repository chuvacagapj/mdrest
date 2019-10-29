package models;

import play.data.validation.MaxSize;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * Created by jesus on 28/11/16.
 * Utilizado como ejemplo para las cosas de git
 */
@Entity
public class MarkdownModel extends Model{

    public String title;

    @Lob
    @MaxSize(1000000)
    public String body;

    @Override
    public String toString(){
        return  title;
    }
}

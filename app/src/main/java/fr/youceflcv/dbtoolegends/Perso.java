package fr.youceflcv.dbtoolegends;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youcef.kadarabah on 06/12/19.
 */

class Perso {
    private String name;
    private String subname;

    private Set<String> tags = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getSubname() {
        return subname;
    }


    public void addTag(String text) {
        tags.add(text);
/*        for (String s : tags
                ) {

        }*/
    }


    public Set<String> getTags() {
        return tags;
    }
}

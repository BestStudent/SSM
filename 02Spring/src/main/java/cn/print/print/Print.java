package cn.print.print;

import cn.print.ink.Ink;
import cn.print.paper.Paper;

public class Print {
  private Ink ink;

  public Ink getInk() {
    return ink;
  }

  public void setInk(Ink ink) {
    this.ink = ink;
  }

  private Paper paper;


  public Paper getPaper() {
    return paper;
  }

  public void setPaper(Paper paper) {
    this.paper = paper;
  }

  public  void print(){
    System.out.println("用"+ink.getClour()+"\t颜色的墨盒在"+paper.getPaper()+"\t类型的纸张上打印出来 我爱你中国");
  }

}
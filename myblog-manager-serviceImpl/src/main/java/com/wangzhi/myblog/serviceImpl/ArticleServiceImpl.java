package com.wangzhi.myblog.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangzhi.blog.mapper.ArticleMapper;
import com.wangzhi.blog.mapper.TagMapper;
import com.wangzhi.blog.mapper.custom.ArticleCustomMapper;
import com.wangzhi.blog.mapper.custom.CommentCustomMapper;
import com.wangzhi.blog.mapper.custom.UserCustomMapper;
import com.wangzhi.myblog.service.ArticleService;
import com.wangzhi.pojo.Article;
import com.wangzhi.pojo.custom.*;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private UserCustomMapper userCustomMapper;
    @Autowired
    private CommentCustomMapper commentCustomMapper;
    @Autowired
    private ArticleCustomMapper articleCustomMapper;

    @Override
    public List<ArticleCustomVo> getArticleListByPage(Integer status, Integer pageNow, Integer pageSize) {
        if(pageSize!=null){
            PageHelper .startPage(pageNow,pageSize);
        }
        List<ArticleCustom> articleCustomList=articleCustomMapper.getArticleCustomList(status);
        PageInfo<ArticleCustom> pageInfo=new PageInfo<>(articleCustomList);
        List<ArticleCustomVo> articleCustomVoList=new ArrayList<>();
        for(int i=0;i<articleCustomList.size();i++){
            ArticleCustomVo articleCustomVo=new ArticleCustomVo();
            articleCustomVo.setArticleCustom(articleCustomList.get(i));
            String articleTagIds = articleCustomList.get(i).getArticleTagIds();
            if(articleTagIds!=null && articleTagIds!="") {
                String[] tagId=articleTagIds.split(",");
                for (int j = 0; j < tagId.length; j++) {
                    TagCustom tagCustom = tagMapper.getTagById(Integer.valueOf(tagId[j]));
                    articleCustomVo.getTagCustomList().add(tagCustom);
                    articleCustomVo.setPage(pageInfo);
                }
            }
            articleCustomVoList.add(articleCustomVo);
        }
        return articleCustomVoList;
    }
    //获取文章及其相关信息
    @Override
    public ArticleDetailVo getArticleDetailVoById(Integer articleId) {
        ArticleDetailVo articleDetailVo=new ArticleDetailVo();
        //获取文章信息
        ArticleCustom articleCustom = articleCustomMapper.getArticleCustomById(articleId);
        articleDetailVo.setArticleCustom(articleCustom);
        //获取文章作者信息
        UserCustom userCustom = userCustomMapper.getUserById(articleCustom.getArticleUserId());
        articleDetailVo.setUserCustom(userCustom);
        //获取文章评论列表
        List<CommentCustom> commentCustomList = commentCustomMapper.getCommentCustomByArticleId(articleCustom.getArticleId());
        articleDetailVo.setCommentCustomList(commentCustomList);
        //获取文章标签信息
        String articleTagIds = articleCustom.getArticleTagIds();
        if(articleTagIds!=null && articleTagIds!="") {
            String[] tagId=articleTagIds.split(",");
            for (int j = 0; j < tagId.length; j++) {
                TagCustom tagCustom = tagMapper.getTagById(Integer.valueOf(tagId[j]));
                articleDetailVo.getTagCustomList().add(tagCustom);
            }
        }
        return articleDetailVo;
    }
    //获取访问量多的文章
    @Override
    public List<Article> getArticleByViewCount(Integer status, Integer limit) {
        List<Article> articleList=articleCustomMapper.getArticleByViewCount(status,limit);
        return articleList;
    }
    //获取下一篇文章
    @Override
    public Article getAfterArticle(Integer status, Integer articleId) {
        Article article=articleCustomMapper.getAfterArticle(status,articleId);
        return article;
    }
    //获取上一篇文章
    @Override
    public Article getPreviousArticle(Integer status, Integer articleId) {
        Article article=articleCustomMapper.getPreViousArticle(status,articleId);
        return article;
    }
    //根据文章id获取文章
    @Override
    public Article getArticleById(Integer status, Integer articleId) {
        Article article=articleCustomMapper.getArticleById(status,articleId);
        return article;
    }

    @Override
    public List<Article> articleListWithSameCategory(Integer status, Integer articleParentCategoryId, Integer articleChildCategoryId) {
        List<Article> articleListWithSameCategory=articleCustomMapper.getArticleListWithSameCategory(status,articleParentCategoryId,articleChildCategoryId);
        return articleListWithSameCategory;
    }
    //添加文章
    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }
    //根据分类的id获取文章列表
    @Override
    public List<ArticleCustomVo> getArticleCustomVoListById(Integer status, Integer pageNow, Integer pageSize, Integer id) {
        if(pageSize!=null){
            PageHelper .startPage(pageNow,pageSize);
        }
        List<ArticleCustom> articleCustomList=articleCustomMapper.getArticleCustomListById(status,id);
        PageInfo<ArticleCustom> pageInfo=new PageInfo<>(articleCustomList);
        List<ArticleCustomVo> articleCustomVoList=new ArrayList<>();
        for(int i=0;i<articleCustomList.size();i++){
            ArticleCustomVo articleCustomVo=new ArticleCustomVo();
            articleCustomVo.setArticleCustom(articleCustomList.get(i));
            String articleTagIds = articleCustomList.get(i).getArticleTagIds();
            if(articleTagIds!=null && articleTagIds!="") {
                String[] tagId=articleTagIds.split(",");
                for (int j = 0; j < tagId.length; j++) {
                    TagCustom tagCustom = tagMapper.getTagById(Integer.valueOf(tagId[j]));
                    articleCustomVo.getTagCustomList().add(tagCustom);
                    articleCustomVo.setPage(pageInfo);
                }
            }
            articleCustomVoList.add(articleCustomVo);
        }
        return articleCustomVoList;
    }

    @Override
    public void deleteArticleById(Integer id) {
        articleMapper.deleteArticleById(id);
    }

    @Override
    public void deleteArticleByIds(Integer[] id) {
        articleMapper.deleteArticleByIds(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Override
    public Map<String, Object> importArticle() {
        List<ArticleCustom> articleCustomList = articleCustomMapper.getArticleCustomList(1);
        return null;
    }

    @Override
    public Integer countArticleWithCategory(Integer id) {
        return articleMapper.countArticleWithCategory(id);
    }
}

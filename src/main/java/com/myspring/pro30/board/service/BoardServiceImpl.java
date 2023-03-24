package com.myspring.pro30.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.board.dao.BoardDAO;
import com.myspring.pro30.board.vo.ArticleVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl  implements BoardService{
	//(required = true)
	@Autowired
	BoardDAO boardDAO;
	
	public List<ArticleVO> listArticles() throws Exception{
		List<ArticleVO> articlesList =  boardDAO.selectAllArticlesList();
        return articlesList;
        
	}

	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		
		return boardDAO.insertNewArticle(articleMap);
	}
	
	 //단일 파일 보이기
		@Override
		public ArticleVO viewArticle(int articleNO) throws Exception {
			ArticleVO articleVO = boardDAO.selectArticle(articleNO);
			return articleVO;
		}
		
		//수정하기 했을 때
		@Override
		public void modArticle(Map articleMap) throws Exception {
			boardDAO.updateArticle(articleMap);
		}
		
		//글 삭제
		@Override
		public void removeArticle(int articleNO) throws Exception {
			boardDAO.deleteArticle(articleNO);
		}
		
	}
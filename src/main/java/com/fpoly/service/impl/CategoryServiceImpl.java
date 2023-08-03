package com.fpoly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.dao.CategoryDAO;
import com.fpoly.entity.Category;
import com.fpoly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO cateDAO;
	@Override
	public List<Category> findAll() {
		return cateDAO.findAll();
	}

}

package com.javazero.demo.category;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Id;

import com.javazero.demo.post.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;
	
	@Column(name = "type_category")
	private String typeCategory;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@OrderBy("title")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Post> posts;
}

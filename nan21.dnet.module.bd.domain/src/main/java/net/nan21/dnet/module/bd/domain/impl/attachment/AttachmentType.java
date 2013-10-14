/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.attachment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/** Attachment type definition.*/
@NamedQueries({@NamedQuery(name = AttachmentType.NQ_FIND_BY_NAME, query = "SELECT e FROM AttachmentType e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AttachmentType.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AttachmentType.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class AttachmentType extends AbstractType {

	public static final String TABLE_NAME = "BD_ATCH_TYPE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AttachmentType.findByName";

	@NotBlank
	@Column(name = "CATEGORY", nullable = false, length = 8)
	private String category;

	/** Physical location where attachments of this type should be copied if they are uploaded. */
	@Column(name = "UPLOADPATH", length = 400)
	private String uploadPath;

	/** Base URL to use when the attachment is requested. Is ignored if the attachment specifies an absolute URL */
	@NotBlank
	@Column(name = "BASEURL", nullable = false, length = 255)
	private String baseUrl;

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUploadPath() {
		return this.uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

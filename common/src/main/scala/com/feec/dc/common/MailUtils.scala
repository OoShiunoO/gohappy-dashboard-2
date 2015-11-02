package com.feec.dc.common

import javax.activation.CommandMap
import javax.activation.MailcapCommandMap
import org.apache.commons.mail.EmailAttachment
import org.apache.commons.mail.MultiPartEmail
import org.apache.commons.lang3.StringUtils

object MailUtils {

  private val mc = CommandMap.getDefaultCommandMap().asInstanceOf[MailcapCommandMap]
  mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html")
  mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml")
  mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain")
  mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed")
  mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822")
  CommandMap.setDefaultCommandMap(mc)
  
 
  def attachment(file: String, name: String = "", description: String = "") = {
    val attachment = new EmailAttachment()
    
    attachment.setPath(file)
    attachment.setDisposition(EmailAttachment.ATTACHMENT)
    attachment.setDescription(if (StringUtils.isBlank(description)) file else description)
    attachment.setName(if (StringUtils.isBlank(name)) file else name)
    attachment
  }
  
  def sendFile(host: String, sender: String, to: String, subject: String, content: String, file: String, fileAlias: String) {
    /*val attachment = new EmailAttachment()
    
    attachment.setPath(file)
    attachment.setDisposition(EmailAttachment.ATTACHMENT)
    attachment.setDescription(fileAlias)
    attachment.setName(fileAlias)*/
    
    val attachFile = attachment(file, fileAlias, fileAlias)
    
    val email = new MultiPartEmail()
    email.setHostName(host)
    email.addTo(to, to)
    email.setFrom(sender, sender)
    email.setSubject(subject)
    email.setMsg(content)

    email.attach(attachFile)


    email.send()
  }
  
  def sendFile(host: String, sender: String, to: Array[String], bcc: Array[String], subject: String, content: String, file: String, fileAlias: String) {
    val attachFile = attachment(file, fileAlias, fileAlias)
    
    val email = new MultiPartEmail()
    email.setHostName(host)
    email.addTo(to: _*)

    if (bcc != null && bcc.length > 0) {
      email.addBcc(bcc: _*)
    }
    email.setFrom(sender, sender)
    email.setSubject(subject)
    email.setMsg(content)

    email.attach(attachFile)
    email.send()
    
  }
}
package com.codingthearchitecture.util;

/**
 * A collection of utility methods for manipulating strings.
 *
 * @author    Simon Brown
 */
public final class StringUtils {

  public static final int MAX_CONTENT_LENGTH = 255;
  public static final int MAX_WORD_LENGTH = 20;

  /**
   * Filters out all HTML tags.
   *
   * @param s   the String to filter
   * @return    the filtered String
   */
  public static String filterHtml(String s) {
    if (s == null) {
      return null;
    }

    s = s.replaceAll("&lt;", "");
    s = s.replaceAll("&gt;", "");
    s = s.replaceAll("&nbsp;", "");
    s = s.replaceAll("(?s)<!--.*?-->", "");
    return s.replaceAll("(?s)<.*?>", "");
  }

  public static String filterHtmlAndTruncate(String s) {
    return filterHtmlAndTruncate(s, MAX_CONTENT_LENGTH);
  }

  public static String filterHtmlAndTruncate(String s, int maxLength) {
    String content = filterHtml(s);

    // then truncate, if necessary
    if (content == null) {
      return "";
    } else {
      StringBuilder buf = new StringBuilder();

      String words[] = content.split("\\s");
      for (int i = 0; i < words.length; i++) {
        if (buf.length() + words[i].length() > maxLength) {
          buf.append("...");
          return buf.toString();
        } else if (words[i].length() > MAX_WORD_LENGTH) {
          buf.append(words[i].substring(0, MAX_WORD_LENGTH));
          buf.append("...");
          return buf.toString();
        } else {
          buf.append(words[i]);
          if ((i+1) < words.length) {
            buf.append(" ");
          }
        }
      }

      return buf.toString();
    }
  }

}
package encoding.test

class DemoCodec {

  static encode = {input ->
    String result = input?.encodeAsHTML()?.replaceAll("\\n", "<br/>");
    return result
  }

  static decode = {string ->
    String result = string?.replaceAll("<br/>", "\\n")?.decodeHTML()
    return result
  }
}

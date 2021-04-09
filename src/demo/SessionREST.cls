Class demo.SessionREST Extends Sample.REST.Base
{

Parameter Version = "1.0.0";

XData UrlMap [ XMLNamespace = "http://www.intersystems.com/urlmap" ]
{
<Routes>
<Route Url="/" Method="GET" Call="GetVersion" Cors="true"/>
<Route Url="/_spec" Method="GET" Call="SwaggerSpec" />
<Route Url="/session/:id" Method="GET" Call="Get"/>
<Route Url="/session/:id" Method="PUT" Call="Update"/>
<Route Url="/session/:id" Method="DELETE" Call="Delete"/>
<Route Url="/session/" Method="POST" Call="Create"/>
</Routes>
}

/// REST general information
ClassMethod GetVersion() As %Status
{
  SET version = ..#Version
  SET info = {
    "version": (version)
  }
  RETURN ..%ProcessResult($$$OK, info)
}

ClassMethod Get(key As %String) As %Status
{
	#dim tSC As %Status = $$$OK
    #dim e As %Exception.AbstractException

    #; Set the response header to plain text
    Set %response.ContentType = ..#CONTENTTYPEJSON

    Set a = ##class(demo.Session).%OpenId(id)

    If '$IsObject(a) Quit ..Http404()

    Do a.%JSONExport()

    Quit tSC
}

ClassMethod Create() As %Status
{
	#dim tSC As %Status = $$$OK
    #dim e As %Exception.AbstractException
    Set a = ##class(demo.Session).%New()
    Set data=%request.Content


    $$$TOE(tSC,a.%JSONImport(data))
    $$$TOE(tSC,a.%Save())

    Set %response.Status = 204
    Set %response.ContentType = ..#CONTENTTYPEJSON
    Do a.%JSONExport()

    Quit tSC
}

ClassMethod Update(id As %String) As %Status
{
	#dim tSC As %Status = $$$OK
    #dim e As %Exception.AbstractException
    Set a = ##class(demo.Session).%OpenId(id)
    If '$IsObject(a) Return ..Http404()
    Set data=%request.Content

    $$$TOE(tSC,a.%JSONImport(data))
    $$$TOE(tSC,a.%Save())

    Set %response.Status = 200

    Set %response.ContentType = ..#CONTENTTYPEJSON
    Do a.%JSONExport()

    Quit tSC
}

/// Delete a record with id in Sample.Person
ClassMethod Delete(id As %String) As %Status
{
	#dim tSC As %Status = $$$OK
    #dim e As %Exception.AbstractException
    Set a = ##class(demo.Session).%OpenId(id)
    If '$IsObject(a) Return ..Http404()

    $$$TOE(tSC,a.%DeleteId(id))

    Set %response.Status = 200

    Set %response.ContentType = ..#CONTENTTYPEJSON

    Quit tSC
}

ClassMethod SwaggerSpec() As %Status
{
  Set tSC = ##class(%REST.API).GetWebRESTApplication($NAMESPACE, %request.Application, .swagger)
  Do swagger.info.%Remove("x-ISC_Namespace")
  Set swagger.basePath = "/crud"
  Set swagger.info.title = "InterSystems IRIS REST demo"
  Set swagger.info.version = "0.1"
  Set swagger.host = "localhost:52773"
  Return ..%ProcessResult($$$OK, swagger)
}

}

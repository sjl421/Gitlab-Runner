#!/bin/sh

# delete all resources from project
oc delete all -l app=telecom-cloud-example

# delete the project
oc delete project telecom-cloud-example --force=true

# delete all templates
oc delete template telecom-cloud-sap
oc delete template telecom-cloud-eapi
oc delete template telecom-cloud-bff
oc delete template telecom-cloud-webapp

# create new project
oc new-project telecom-cloud-example

# deploy to openshift
oc create -f openshift-template-sap.yml
oc create -f openshift-template-eapi.yml
oc create -f openshift-template-eapi2.yml
oc create -f openshift-template-bff.yml
oc create -f openshift-template-webapp.yml


oc new-app telecom-cloud-sap
oc new-app telecom-cloud-eapi
oc new-app telecom-cloud-eapi2
oc new-app telecom-cloud-bff
oc new-app telecom-cloud-webapp
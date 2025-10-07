variable "project_name" { type = string  default = "t1-arq-software" }
variable "region"       { type = string  default = "us-east-1" }
variable "env"          { type = string  default = "prod" }

variable "app_port"     { type = number  default = 8080 }

# GitHub OIDC
variable "github_org"  { type = string  default = "Will0301" }
variable "github_repo" { type = string  default = "T1-arq-software" }

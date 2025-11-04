variable "region" {
  default = "us-east-1"
}

variable "instance_type" {
  default = "t3.micro"
}

variable "key_name" {
  description = "Nome do par de chaves SSH existente"
}

variable "docker_image" {
  description = "Imagem Docker completa, ex: usuario/app:latest"
}

variable "rds_endpoint" {
  description = "Endpoint do banco RDS existente"
}

variable "rds_username" {}
variable "rds_password" {}

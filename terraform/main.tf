resource "aws_security_group" "api_sg" {
  name_prefix = "api-sg-"

  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "api_server" {
  ami                    = "ami-0c02fb55956c7d316" # Amazon Linux 2023
  instance_type          = var.instance_type
  key_name               = var.key_name
  vpc_security_group_ids = [aws_security_group.api_sg.id]
  associate_public_ip_address = true

  user_data = <<-EOF
              #!/bin/bash
              yum update -y
              amazon-linux-extras install docker -y
              systemctl enable docker
              systemctl start docker
              docker pull ${var.docker_image}
              docker run -d -p 8080:8080 \
                -e SPRING_DATASOURCE_URL=jdbc:postgresql://${var.rds_endpoint}:5432/meubanco \
                -e SPRING_DATASOURCE_USERNAME=${var.rds_username} \
                -e SPRING_DATASOURCE_PASSWORD=${var.rds_password} \
                -e JWT_ISSUER=https://teu-dominio.auth0.com/ \
                -e JWT_AUDIENCE=https://atividade3-api \
                ${var.docker_image}
              EOF

  tags = {
    Name = "api-server"
  }
}

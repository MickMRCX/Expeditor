USE [Expeditor]
GO

/****** Object:  Table [dbo].[Droits]    Script Date: 21/06/2016 14:03:18 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Droits](
	[Login] [varchar](100) NOT NULL,
	[Libelle] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Login] ASC,
	[Libelle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Droits]  WITH CHECK ADD  CONSTRAINT [FK_Droits_Utilisateurs] FOREIGN KEY([Login])
REFERENCES [dbo].[Utilisateurs] ([Login])
GO

ALTER TABLE [dbo].[Droits] CHECK CONSTRAINT [FK_Droits_Utilisateurs]
GO


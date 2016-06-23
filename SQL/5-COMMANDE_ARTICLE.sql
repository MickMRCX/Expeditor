USE [Expeditor]
GO

/****** Object:  Table [dbo].[Commande_Article]    Script Date: 23/06/2016 11:12:35 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Commande_Article](
	[Article_id] [int] NOT NULL,
	[Commande_id] [int] NOT NULL,
	[Quantite_carton] [int] NOT NULL,
	[Quantite_commandee] [int] NOT NULL,
 CONSTRAINT [PK__Commande__2141DC3E57045392] PRIMARY KEY CLUSTERED 
(
	[Article_id] ASC,
	[Commande_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Commande_Article]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Article_Articles] FOREIGN KEY([Article_id])
REFERENCES [dbo].[Articles] ([Identifiant])
GO

ALTER TABLE [dbo].[Commande_Article] CHECK CONSTRAINT [FK_Commande_Article_Articles]
GO

ALTER TABLE [dbo].[Commande_Article]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Article_Commande] FOREIGN KEY([Commande_id])
REFERENCES [dbo].[Commande] ([Identifiant])
GO

ALTER TABLE [dbo].[Commande_Article] CHECK CONSTRAINT [FK_Commande_Article_Commande]
GO


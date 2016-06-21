USE [Expeditor]
GO

/****** Object:  Table [dbo].[Commande]    Script Date: 21/06/2016 14:02:06 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Commande](
	[Identifiant] [int] IDENTITY(1,1) NOT NULL,
	[Date_Commande] [date] NOT NULL,
	[Nom_Client] [ntext] NOT NULL,
	[Adresse] [ntext] NOT NULL,
	[Etat_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Identifiant] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

ALTER TABLE [dbo].[Commande]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Etat] FOREIGN KEY([Etat_id])
REFERENCES [dbo].[Etat] ([Identifiant])
GO

ALTER TABLE [dbo].[Commande] CHECK CONSTRAINT [FK_Commande_Etat]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Table des commandes' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Commande'
GO

